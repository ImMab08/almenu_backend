package conection_db;

public class Main {

    public static void main(String[] args) {
        conect obj_product = new conect();
        // obj_product.insertar();
        // obj_product.consultar();
        // obj_product.actualizar();
        obj_product.consultar();
        obj_product.eliminar();
        obj_product.consultar();
    }

}
