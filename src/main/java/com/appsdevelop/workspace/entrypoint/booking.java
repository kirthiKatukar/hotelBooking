package com.appsdevelop.workspace.entrypoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.BeanUtils;

import com.appsdevelop.workspace.dto.HotelBookingDto;
import com.appsdevelop.workspace.rest.HotelDetails;
import com.appsdevelop.workspace.service.BookingService;
import com.appsdevelop.workspace.service.impl.HotelBookingImpl;


@Path("/booking")
public class booking {
	
	  @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	    public HotelDetails createHotelBooking(HotelDetails hotelDetails) {

		  HotelDetails returnValue = null;
	        
		  HotelBookingDto hotelBookingDto = new HotelBookingDto();
	        BeanUtils.copyProperties(hotelDetails, hotelBookingDto);
	        
	        BookingService bookingService = (BookingService) new HotelBookingImpl();
	        HotelBookingDto storedDetails = bookingService.saveHotel(hotelBookingDto);
	         
	        if(storedDetails != null && !storedDetails.getHotelName().isEmpty())
	        {
	            returnValue = new HotelDetails();
	            BeanUtils.copyProperties(storedDetails, returnValue);
	        }

	       // And when we are done, we can return user profile back
	        return hotelDetails;
	    }

}
