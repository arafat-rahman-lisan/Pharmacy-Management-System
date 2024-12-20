package interfaces;
import java.lang.*;
import entities.*;


public interface IOwnerRepo
{
	void addOwner(Owner a);
	void removeOwner(String id);
	void updateOwner(Owner a);
	Owner searchOwnerByUserId(String id);
	Owner[] getAllOwner();
}