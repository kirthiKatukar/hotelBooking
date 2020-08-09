package com.appsdevelop.workspace.service.impl;

import org.springframework.beans.BeanUtils;

import com.appsdevelop.workspace.dto.HotelBookingDto;
import com.appsdevelop.workspace.io.dao.Database;
import com.appsdevelop.workspace.io.entity.HotelBookingEntity;


public class HotelBookingImpl {
	
	Database database;
	
	 public HotelBookingDto saveHotel(HotelBookingDto hotelDto) {
	        
		 HotelBookingDto returnValue = null;
	        
		 HotelBookingEntity hotelEntity = new HotelBookingEntity();
	        BeanUtils.copyProperties(hotelDto, hotelEntity);
	        
	        // Connect to database 
	        try {
	            this.database.openConnection();
	            HotelBookingEntity storedEntity = this.database.saveHotelBook(hotelEntity);
	            if(storedEntity != null && storedEntity.getHotelID()>0)
	            {
	                returnValue = new HotelBookingDto();
	                BeanUtils.copyProperties(storedEntity, returnValue);
	            }
	        }  finally {
	            this.database.closeConnection();
	        }
	        
	        return returnValue;
	    }

}
