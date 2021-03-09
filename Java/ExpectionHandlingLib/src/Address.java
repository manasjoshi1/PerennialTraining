
public class Address implements Comparable<Address>{
String city;
int pin;
public Address(String city,int pin) {
this.city=city;
this.pin=pin;
}
public boolean equals(Object obj) {
	Address a=(Address)obj;
	return this.city.equals(a.city) && this.pin==(a.pin);
}
@Override
public int compareTo(Address o) {
	// TODO Auto-generated method stub
	
	return this.city.compareTo(o.city);
}

}
