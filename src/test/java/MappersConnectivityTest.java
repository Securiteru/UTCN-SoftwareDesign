import data_source_logic_layer.AccountMapper;
import data_source_logic_layer.ClientMapper;
import data_source_logic_layer.DBConnection;
import data_source_logic_layer.LoginMapper;
import data_source_logic_layer.exceptions.DataMapperException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class MappersConnectivityTest {
	public static LoginMapper mappy;
	public static AccountMapper mappy2;
	public static ClientMapper mappy3;

	@BeforeClass
	public static void setUp() throws Exception {
		DBConnection conexiune = DBConnection.getConnection();
		mappy=new LoginMapper(conexiune);
		mappy2=new AccountMapper(conexiune);
		mappy3=new ClientMapper(conexiune);
	}

	@Test
	public void LoginNullTest(){
		try {
			assertNull(mappy.findByLoginId(0));
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void AccountNullTest(){
		try {
			assertNull(mappy2.findByAccountId(0));
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ClientNullTest(){
		try {
			assertNull(mappy3.findByClientId(0));
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
	}
}
