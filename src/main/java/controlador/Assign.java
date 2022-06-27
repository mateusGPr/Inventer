package controlador;

import jakarta.servlet.http.HttpServletRequest;

public class Assign{
	public interface Run {
		void set(String str);
	}

	public static boolean Value(Run rn, HttpServletRequest request, String name) {
		if (request.getParameter(name) != null && !request.getParameter(name).trim().equals("")) {
			rn.set(request.getParameter(name));
			return true;
		}
		return false;
	}
}