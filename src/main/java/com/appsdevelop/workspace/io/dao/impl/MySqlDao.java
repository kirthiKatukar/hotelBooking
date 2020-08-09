package com.appsdevelop.workspace.io.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.appsdevelop.workspace.io.entity.HotelBookingEntity;
import com.appsdevelop.workspace.utils.HibernateUtils;



public class MySqlDao {
	
	Session session;

    public void openConnection() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        this.session = sessionFactory.openSession();
    }
    
    public HotelBookingEntity saveHotelBook(HotelBookingEntity hotelEntity) {

        this.session.beginTransaction();
        this.session.save(hotelEntity);
        this.session.getTransaction().commit();

        return hotelEntity;
    }

    public void closeConnection() {
        this.session.close();
    }

}
