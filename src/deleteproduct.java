package master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import generatedclass.connectionclass;

public class deleteproduct extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	
	public String prodtId;
    public String getProdtId() {
		return prodtId;
	}
	public void setProdtId(String prodtId) {
		this.prodtId = prodtId;
	}
	public String ret="error";
	public String execute() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		new connectionclass();
		Connection con=connectionclass.getConnection();
		String query="delete from product where id=?";
		
		try {
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, prodtId);
			pst.executeUpdate();
			
			
			request.getSession().setAttribute("successmsg", "Data Deleted");
			ret="success";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret="error";
		}
		
		return ret;
	}
	
	

	
}
