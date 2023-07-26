
package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.BVO;
import com.ict.db.DAO;

public class UpdateCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String b_idx = request.getParameter("b_idx");
		BVO bvo = DAO.getOneList(b_idx);
		
		if(bvo != null) {
			request.setAttribute("bvo", bvo);
			return "view/update.jsp";
		}else {
			return "MyController?cmd=onelist&b_idx="+b_idx;
		}
	}
}