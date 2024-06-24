package ejercicio3c;

public class Usuario{
String nombreUsuario;
String nombreYApellido;
Compra[] compras;
boolean esVendedor;


@Override
public String toString() {
    return "Usuario{" +
            "nombreUsuario='" + nombreUsuario + '\'' +
            ", nombreYApellido='" + nombreYApellido + '\'' +
            ", esVendedor=" + esVendedor +
            '}';
}
}