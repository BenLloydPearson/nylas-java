package com.nylas;

import java.io.IOException;
import java.util.List;

/**
 * @see https://docs.nylas.com/reference#calendars
 */
public class Calendars extends RestfulCollection<Calendar, CalendarQuery>{

	Calendars(NylasClient client, String accessToken) {
		super(client, Calendar.class, "calendars", accessToken);
	}

	@Override
	public List<String> ids(CalendarQuery query) throws IOException, RequestFailedException {
		return super.ids(query);
	}

	@Override
	public long count(CalendarQuery query) throws IOException, RequestFailedException {
		return super.count(query);
	}
}