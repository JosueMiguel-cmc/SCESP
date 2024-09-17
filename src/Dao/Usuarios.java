package Dao;
import java.util.*;

import VO.UsuarioVo;
public class Usuarios {
    public int retornaTotalUser(ArrayList<UsuarioVo> user){
        int total = user.size();
        return total;
    }
}
