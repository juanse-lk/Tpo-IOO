package dto;

import models.ProductoServicio;
import models.Rubro;

import java.util.ArrayList;
import java.util.List;

public class RubroDTO {

    // Atributos
    public List<ProductoServicio> listaProductoServicio;
    public int idRubro;
    public   String nombreRubro;

    // Metodos



    // Constructors


    public RubroDTO() {

    }

    public static Rubro toModel(RubroDTO dto){
        return new Rubro(
                dto.idRubro,
                dto.nombreRubro,
                dto.listaProductoServicio);
    }

    public static RubroDTO toDTO(Rubro r) {
        return null;
    }

    public RubroDTO(int idRubro, String nombreRubro, List<ProductoServicio> listaProductoServicio){
        this.idRubro=idRubro;
        this.nombreRubro=nombreRubro;
        this.listaProductoServicio=listaProductoServicio;
    }


    // Metodos de RubroDTO
}
