package com.teamyostrik.easystock.services.strategy;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface Strategy<T> {
    T savePhoto(Integer id,InputStream photo, String title) throws FlickrException;
}
