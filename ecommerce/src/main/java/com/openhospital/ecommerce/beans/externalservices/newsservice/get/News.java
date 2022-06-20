package com.openhospital.ecommerce.beans.externalservices.newsservice.get;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

/**
 * News
 */
@Data
@ToString
public class News {

	private Integer id;
	private String lang;
	private String institution;
	private String institutionImage;
	private String title;
	private String shortDescription;
	private String description;
	private String image;
	private String link;
	private Boolean clickable = false;
	private Instant insertTimestamp;
	private Instant updateTimestamp;
	private Boolean enabled = false;
}