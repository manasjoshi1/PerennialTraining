package bank.server.internal;

import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;

import bank.iserver.internal.service.AccountRepository;
import bank.iserver.internal.service.AccountService;
import bank.server.Bank;

@Configuration("configBank")
@ImportResource("test-infrastructure-Java_Based_config.xml")
public class BankConfig {

	private @Value("#{jdbcProperties.oracleURL}") String url;
	private @Value("#{jdbcProperties.oracleUser}") String username;
	private @Value("#{jdbcProperties.oraclePassword}") String password;
	private @Value("#{jdbcProperties.oracleDriver}") String driverClassName;

	@Bean(name="bankService") // if name is not specified then name of the Bean is same Collection<E> the method
	@Scope("prototype")
	Bank  bankService(){
		Collection<AccountService> accts = new ArrayList<AccountService>();
		accts.add(currentAccount());
		accts.add(loan());
		accts.add(saving());
		return new BankImpl(accountRepository(),accts);
	}
	@Bean(name="acctRepo")
	AccountRepository accountRepository(){
		return new AccountRepositoryImpl(dataSource());	
	}
	@Bean(name="current")
	AccountService currentAccount(){
		CurentAccount acct= new CurentAccount("Ramkrishna IT",1000000);
		acct.setAcctNo(123456789);
		return acct;

	}
	@Bean(name="saving")
	AccountService saving(){
		SavingsType saving = new SavingsType("vivek Kulkarni");
		saving.setInterestRate(10.5f);
		return saving;

	}

	@Bean(name="loan")
	AccountService loan(){
		LoanAccount loan = new LoanAccount("HousingLoan", 15);
		loan.setRateOfInterest(11.5f);
		return loan;

	}

	public @Bean DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}


}
