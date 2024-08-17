package org.mehtor;


import java.util.UUID;

public class User {
	private String gender;
	private Name name;
	private Location location;
	private String email;
	private Login login;
	private Dob dob;
	private Dob registered;
	private String phone;
	private String cell;
	private ID id;
	private Picture picture;
	private String nat;
	
	
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Name getName() {
		return name;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public Dob getDob() {
		return dob;
	}
	
	public void setDob(Dob dob) {
		this.dob = dob;
	}
	
	public Dob getRegistered() {
		return registered;
	}
	
	public void setRegistered(Dob registered) {
		this.registered = registered;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCell() {
		return cell;
	}
	
	public void setCell(String cell) {
		this.cell = cell;
	}
	
	public ID getId() {
		return id;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	
	public Picture getPicture() {
		return picture;
	}
	
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	
	public String getNat() {
		return nat;
	}
	
	public void setNat(String nat) {
		this.nat = nat;
	}
	
	public class Picture {
		private String large;
		private String medium;
		private String thumbnail;
		
		public String getLarge() { return large; }
		public void setLarge(String value) { this.large = value; }
		
		public String getMedium() { return medium; }
		public void setMedium(String value) { this.medium = value; }
		
		public String getThumbnail() { return thumbnail; }
		public void setThumbnail(String value) { this.thumbnail = value; }
		
		@Override
		public String toString() {
			return "Picture{" + "large='" + getLarge() + '\'' + ", medium='" + getMedium() + '\'' + ", thumbnail='" + getThumbnail() + '\'' + '}';
		}
	}
	
	public class Name {
		private String title;
		private String first;
		private String last;
		
		public String getTitle() { return title; }
		public void setTitle(String value) { this.title = value; }
		
		public String getFirst() { return first; }
		public void setFirst(String value) { this.first = value; }
		
		public String getLast() { return last; }
		public void setLast(String value) { this.last = value; }
		
		@Override
		public String toString() {
			return "Name{" + "title='" + getTitle() + '\'' + ", first='" + getFirst() + '\'' + ", last='" + getLast() + '\'' + '}';
		}
	}
	public class Login {
		private UUID uuid;
		private String username;
		private String password;
		private String salt;
		private String md5;
		private String sha1;
		private String sha256;
		
		public UUID getUUID() { return uuid; }
		public void setUUID(UUID value) { this.uuid = value; }
		
		public String getUsername() { return username; }
		public void setUsername(String value) { this.username = value; }
		
		public String getPassword() { return password; }
		public void setPassword(String value) { this.password = value; }
		
		public String getSalt() { return salt; }
		public void setSalt(String value) { this.salt = value; }
		
		public String getMd5() { return md5; }
		public void setMd5(String value) { this.md5 = value; }
		
		public String getSha1() { return sha1; }
		public void setSha1(String value) { this.sha1 = value; }
		
		public String getSha256() { return sha256; }
		public void setSha256(String value) { this.sha256 = value; }
		
		@Override
		public String toString() {
			return "Login{" + "uuid=" + uuid + ", username='" + getUsername() + '\'' + ", password='" + getPassword() + '\'' + ", salt='" + getSalt() + '\'' + ", md5='" + getMd5() + '\'' + ", sha1='" + getSha1() + '\'' + ", sha256='" + getSha256() + '\'' + ", UUID=" + getUUID() + '}';
		}
	}
	
	public class Coordinates {
		private String latitude;
		private String longitude;
		
		public String getLatitude() { return latitude; }
		public void setLatitude(String value) { this.latitude = value; }
		
		public String getLongitude() { return longitude; }
		public void setLongitude(String value) { this.longitude = value; }
		
		@Override
		public String toString() {
			return "Coordinates{" + "latitude='" + getLatitude() + '\'' + ", longitude='" + getLongitude() + '\'' + '}';
		}
	}
	public class Street {
		private long number;
		private String name;
		
		public long getNumber() { return number; }
		public void setNumber(long value) { this.number = value; }
		
		public String getName() { return name; }
		public void setName(String value) { this.name = value; }
		
		@Override
		public String toString() {
			return "Street{" + "number=" + getNumber() + ", name='" + getName() + '\'' + '}';
		}
	}
	public class Timezone {
		private String offset;
		private String description;
		
		public String getOffset() { return offset; }
		public void setOffset(String value) { this.offset = value; }
		
		public String getDescription() { return description; }
		public void setDescription(String value) { this.description = value; }
		
		@Override
		public String toString() {
			return "Timezone{" + "offset='" + getOffset() + '\'' + ", description='" + getDescription() + '\'' + '}';
		}
	}
	public class Location {
		private Street street;
		private String city;
		private String state;
		private String country;
		private String postcode;
		private Coordinates coordinates;
		private Timezone timezone;
		
		public Street getStreet() { return street; }
		public void setStreet(Street value) { this.street = value; }
		
		public String getCity() { return city; }
		public void setCity(String value) { this.city = value; }
		
		public String getState() { return state; }
		public void setState(String value) { this.state = value; }
		
		public String getCountry() { return country; }
		public void setCountry(String value) { this.country = value; }
		
		public String getPostcode() { return postcode; }
		public void setPostcode(String value) { this.postcode = value; }
		
		public Coordinates getCoordinates() { return coordinates; }
		public void setCoordinates(Coordinates value) { this.coordinates = value; }
		
		public Timezone getTimezone() { return timezone; }
		public void setTimezone(Timezone value) { this.timezone = value; }
		
		@Override
		public String toString() {
			return "Location{" + "street=" + getStreet() + ", city='" + getCity() + '\'' + ", state='" + getState() + '\'' + ", country='" + getCountry() + '\'' + ", postcode='" + getPostcode() + '\'' + ", coordinates=" + getCoordinates() + ", timezone=" + getTimezone() + '}';
		}
	}
	
	public class ID {
		private String name;
		private String value;
		
		public String getName() { return name; }
		public void setName(String value) { this.name = value; }
		
		public String getValue() { return value; }
		public void setValue(String value) { this.value = value; }
		
		
		@Override
		public String toString() {
			return "ID{" + "name='" + getName() + '\'' + ", value='" + getValue() + '\'' + '}';
		}
	}
	
	public class Dob {
		private String date;
		private long age;
		
		public String getDate() { return date; }
		public void setDate(String value) { this.date = value; }
		
		public long getAge() { return age; }
		public void setAge(long value) { this.age = value; }
		
		
		@Override
		public String toString() {
			return "Dob{" + "date='" + getDate() + '\'' + ", age=" + getAge() + '}';
		}
	}
	
	@Override
	public String toString() {
		return "User{" + "gender='" + getGender() + '\'' + ", name=" + getName() + ", location=" + getLocation() + ", email='" + getEmail() + '\'' + ", login=" + getLogin() + ", dob=" + getDob() + ", registered=" + getRegistered() + ", phone='" + getPhone() + '\'' + ", cell='" + getCell() + '\'' + ", id=" + getId() + ", picture=" + getPicture() + ", nat='" + getNat() + '\'' + '}';
	}
}