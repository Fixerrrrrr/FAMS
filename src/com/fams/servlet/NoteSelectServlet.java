package com.fams.servlet;

import com.fams.dao.NoteDao;
import com.fams.dao.impl.NoteDaoImpl;
import com.fams.entity.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by quyuan on 16/10/30.
 */
@WebServlet(name = "NoteSelectServlet")
public class NoteSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=gb2312");

        NoteDao noteDao = new NoteDaoImpl();
        ArrayList<Note> arrayList = noteDao.selectAll();
        request.setAttribute("noteList",arrayList);
        request.getRequestDispatcher("note_show.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
