/**
 * 
 */
package haui.ads.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;

/**
 * @author Dinh Hieu
 *
 */
public class BasicImpl implements Basic {

	// doi tuong ConnectionPool cua rieng Basic
	private ConnectionPool cp;

	// ket noi ma Basic su dung
	protected Connection con;

	// ten doi tuong lam viec void Basic
	private String objectName;

	/**
	 * 
	 */
	public BasicImpl(ConnectionPool cp, String objectName) {
		// xac dinh doi tuong lam viec
		this.objectName = objectName;

		// xac dịn bo quan ly ket noi
		if (cp == null) {
			this.cp = new ConnectionPoolImpl();
		} else {
			this.cp = cp;
		}

		// basic xin 1 ket noi tu cp
		try {
			this.con = this.cp.getconnection(this.objectName);
			// cham dut che do thuc thi tu dong cau lenh SQL
			if (this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private synchronized boolean exe(PreparedStatement pre) {
		if (pre != null) {
			try {
				int result = pre.executeUpdate();

				if (result == 0) {
					this.con.rollback();
					return false;
				}

				// xac lap thuc thi sau cung
				this.con.commit();

				return true;
			} catch (SQLException e) {
				e.printStackTrace();

				// tro lai trang thai an toan trc do
				try {
					this.con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return false;

		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ShareControl#getConnectionPool()
	 */
	@Override
	public ConnectionPool getConnectionPool() {
		return this.cp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ShareControl#releaseConnection()
	 */
	@Override
	public void releaseConnection() {
		try {
			this.cp.releaseConnection(this.con, this.objectName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.basic.Basic#add(java.sql.PreparedStatement)
	 */
	@Override
	public boolean add(PreparedStatement pre) {
		return this.exe(pre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.basic.Basic#edit(java.sql.PreparedStatement)
	 */
	@Override
	public boolean edit(PreparedStatement pre) {
		return this.exe(pre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.basic.Basic#del(java.sql.PreparedStatement)
	 */
	@Override
	public boolean del(PreparedStatement pre) {
		return this.exe(pre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.basic.Basic#get(java.lang.String, int)
	 */
	@Override
	public ResultSet get(String sql, int value) {
		PreparedStatement pre;
		try {
			pre = this.con.prepareStatement(sql);
			if (value > 0) {
				pre.setInt(1, value);
			}
			return pre.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.basic.Basic#get(java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ResultSet get(String sql, String username, String userpass) {
		try {
			PreparedStatement pre = this.con.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, userpass);

			return pre.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();

			try {
				this.con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.basic.Basic#gets(java.lang.String)
	 */
	@Override
	public ResultSet gets(String sql) {
		return this.get(sql, 0);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.basic.Basic#gets(java.lang.String)
	 */
	@Override
	public ResultSet gets(String sql,int value) {
		return this.get(sql, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.basic.Basic#gets(java.lang.String[])
	 */
	@Override
	public ResultSet[] gets(String[] sqls) {
		ResultSet[] tmp = new ResultSet[sqls.length];
		for (int i = 0; i < sqls.length; i++) {
			tmp[i] = this.gets(sqls[i]);
		}
		return tmp;
	}

}
