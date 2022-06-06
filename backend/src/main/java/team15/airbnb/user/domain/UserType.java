package team15.airbnb.user.domain;

public enum UserType {
	CUSTOMER, HOST, SUPER_HOST;

	public boolean isSuperHost() {
		return this == SUPER_HOST;
	}
}
