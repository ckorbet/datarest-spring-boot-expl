package com.cartorgon.drsbe.restrepo;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.cartorgon.drsbe.DataRestSprinbBootExplApplication;
import com.cartorgon.drsbe.model.impl.BeverageEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Test for class {@link BeverageRestRepository}
 * </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataRestSprinbBootExplApplication.class, webEnvironment=WebEnvironment.RANDOM_PORT)
@Slf4j
public class BeverageRestRepositoryTest {
	
	private static final String TESTED_STRING = "%s tested";
	private static final BeverageEntity VODKA_BEVERAGE = new BeverageEntity(3L, "Vodka", 20);
	private static final BeverageEntity COGNAC_BEVERAGE = new BeverageEntity(2L, "Cognac", 20);
	private static final BeverageEntity WHISKEY_BEVERAGE = new BeverageEntity(1L, "Whiskey", 20);
	
	@Autowired
	private BeverageRestRepository repo;
    
    private void checkPreConditions() {
    	assertThat(this.repo).isNotNull();
    	this.repo.deleteAll();
    	assertThat(this.repo.count()).isEqualTo(0);    	
    }
    
    @Before
    public final void init() {
    	this.checkPreConditions();
    }
    
    private void checkBeveragePostConditions(final BeverageEntity beverage, final String expectedName) {
    	assertThat(beverage).isNotNull();
    	assertThat(beverage.getName()).isEqualTo(expectedName);
    }

	@Test
	public void testJpaRepositoryInsert() {		
		// when
		this.repo.saveAll(Arrays.asList(WHISKEY_BEVERAGE, COGNAC_BEVERAGE, VODKA_BEVERAGE));
		
		// then
		assertThat(this.repo.count()).isEqualTo(3);
		this.checkBeveragePostConditions(this.repo.findById(WHISKEY_BEVERAGE.getId()).get(), WHISKEY_BEVERAGE.getName());
		log.info(String.format(TESTED_STRING, WHISKEY_BEVERAGE.getName()));
		this.checkBeveragePostConditions(this.repo.findById(COGNAC_BEVERAGE.getId()).get(), COGNAC_BEVERAGE.getName());
		log.info(String.format(TESTED_STRING, COGNAC_BEVERAGE.getName()));
		this.checkBeveragePostConditions(this.repo.findById(VODKA_BEVERAGE.getId()).get(), VODKA_BEVERAGE.getName());
		log.info(String.format(TESTED_STRING, VODKA_BEVERAGE.getName()));
	}
}