package controlador;

import jakarta.servlet.http.HttpServletRequest;

public class Assign {
	public interface Run {
		void set(String str);
	}

	public static boolean Value(Run rn, HttpServletRequest request, String name) {
		final String arg = request.getParameter(name);
		if ((arg == null) || arg.isBlank()) {
			return false;
		}

		rn.set(arg);
		return true;
	}
}