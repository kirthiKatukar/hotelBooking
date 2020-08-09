package com.appsdevelop.workspace.io.dao;

import com.appsdevelop.workspace.io.entity.HotelBookingEntity;

public interface Database {
	 public void openConnection();
	    public HotelBookingEntity saveHotelBook(HotelBookingEntity hotelEntity);
	    public void closeConnection();
		

}
