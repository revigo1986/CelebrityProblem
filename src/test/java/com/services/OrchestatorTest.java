package com.services;

import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrchestatorTest {
	
	public static Integer CELEBRITY_NOT_FOUND = -1;
	
	@Mock
	Orchestator orchestator;

	@Test
	public void verifyCelebrityFound() throws IOException {
		Integer result = orchestator.execute();
		assertNotEquals(result, CELEBRITY_NOT_FOUND);
	}
}
