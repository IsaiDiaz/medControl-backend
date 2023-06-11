package bo.edu.ucb.med_control.medControl.filter;
import bo.edu.ucb.med_control.medControl.bl.SeUserBL;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
public class TokenAuthenticationFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);
            if(SeUserBL.validateToken(token)){
                return true;
            }else{
                System.out.println("Token no valido");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token no valido");
                return false;
            }
        }else{
            System.out.println("Token no encontrado");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token no valido");
            return false;
        }
    }
}
