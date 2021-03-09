import java.util.Map;

class EmailAction implements Action{
 
public void takeAction(Map<String, String> map) {
	// TODO Auto-generated method stub
	
	SendEmail.send(map);
 }}