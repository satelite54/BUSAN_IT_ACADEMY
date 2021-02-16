package com.bit.springNote.command;

import java.util.List;
import org.springframework.ui.Model;
import com.bit.springNote.DAO.NoteDAO;
import com.bit.springNote.DTO.NoteDTO;;

public class NoteListCommand implements NoteCommand {
	@Override
	public void execute(Model model) {
		NoteDAO dao = new NoteDAO();
		List<NoteDTO> dtos = dao.getNoteList();
		model.addAttribute("list", dtos);
	}
}
