package com.bit.springNote.command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import com.bit.springNote.DAO.NoteDAO;;

public class NoteDeleteCommand implements NoteCommand {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest) map.get("request");
		int id = Integer.parseInt(req.getParameter("id"));
		NoteDAO dao = new NoteDAO();
		dao.delete(id);
	}
}
