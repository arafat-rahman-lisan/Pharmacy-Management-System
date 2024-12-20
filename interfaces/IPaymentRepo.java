package interfaces;

import java.lang.*;
import entities.*;

public interface IPaymentRepo
{
	void addPayment(Payment p);
	void removePayment(String id);
	void updatePayment(Payment p);
	Payment searchPaymentByPaymentId(String id);
	Payment[] searchPaymentByUserId(String id);
	Payment[] getAllPayment();
	
}