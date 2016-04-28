/**
 * 
 */
package haui.ads.statistic;

/**
 * @author Dinh Hieu
 *
 */
public class StatisticItem {

	private long numberPatient;
	private long numberApointment;
	private long numberApointmentSuccess;

	/**
	 * 
	 */
	public StatisticItem() {
	}

	/**
	 * @param numberPatient
	 * @param numberApointment
	 * @param numberApointmentSuccess
	 */
	public StatisticItem(long numberPatient, long numberApointment, long numberApointmentSuccess) {
		this.numberPatient = numberPatient;
		this.numberApointment = numberApointment;
		this.numberApointmentSuccess = numberApointmentSuccess;
	}

	/**
	 * @return the numberPatient
	 */
	public long getNumberPatient() {
		return numberPatient;
	}

	/**
	 * @param numberPatient
	 *            the numberPatient to set
	 */
	public void setNumberPatient(long numberPatient) {
		this.numberPatient = numberPatient;
	}

	/**
	 * @return the numberApointment
	 */
	public long getNumberApointment() {
		return numberApointment;
	}

	/**
	 * @param numberApointment
	 *            the numberApointment to set
	 */
	public void setNumberApointment(long numberApointment) {
		this.numberApointment = numberApointment;
	}

	/**
	 * @return the numberApointmentSuccess
	 */
	public long getNumberApointmentSuccess() {
		return numberApointmentSuccess;
	}

	/**
	 * @param numberApointmentSuccess
	 *            the numberApointmentSuccess to set
	 */
	public void setNumberApointmentSuccess(long numberApointmentSuccess) {
		this.numberApointmentSuccess = numberApointmentSuccess;
	}

}
