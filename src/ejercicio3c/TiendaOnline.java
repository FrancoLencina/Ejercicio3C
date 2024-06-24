package ejercicio3c;

import java.util.Date;


public class TiendaOnline{
Usuario[] usuarios;


	public Usuario mejorVendedor() {
	    Usuario mejor = usuarios[0];
	    String mejorVendedor = usuarios[0].nombreUsuario;
	    int total = 0;
	
	    for (int u = 0; u < usuarios.length; u++) {
	        int cont = 0;
	
	        if (usuarios[u].esVendedor) {
	            for (int c = 0; c < usuarios[u].compras.length; c++) {
	                for (int p = 0; p < usuarios[u].compras[c].carrito.productos.length; p++) {
	                    if (usuarios[u].compras[c].carrito.productos[p].vendedor.nombreUsuario.equals(mejorVendedor)) {
	                        cont++;
	                    }
	                }
	            }
	
	            if (cont >= total) {
	                total = cont;
	                mejorVendedor = usuarios[u].nombreUsuario;
	                mejor = usuarios[u];
	            }
	        }
	    }
	
	    return mejor;
	}
	
	    public static void main(String[] args) {
	        // Crear productos
	        Producto producto1 = new Producto();
	        producto1.nombre = "Producto1";
	        producto1.marca = "Marca1";
	        producto1.tipo = "Tipo1";
	        producto1.precio = 10.0;

	        Producto producto2 = new Producto();
	        producto2.nombre = "Producto2";
	        producto2.marca = "Marca2";
	        producto2.tipo = "Tipo2";
	        producto2.precio = 20.0;
	        
	        Producto producto3 = new Producto();
	        producto1.nombre = "Producto3";
	        producto1.marca = "Marca3";
	        producto1.tipo = "Tipo1";
	        producto1.precio = 30.0;
	        
	        // Crear usuarios
	        Usuario usuario1 = new Usuario();
	        usuario1.nombreUsuario = "vendedor1";
	        usuario1.nombreYApellido = "Juan Perez";
	        usuario1.esVendedor = true;

	        Usuario usuario2 = new Usuario();
	        usuario2.nombreUsuario = "vendedor2";
	        usuario2.nombreYApellido = "Luis Lopez";
	        usuario2.esVendedor = true;

	        Usuario usuario3 = new Usuario();
	        usuario3.nombreUsuario = "comprador";
	        usuario3.nombreYApellido = "Celia Diaz";
	        usuario3.esVendedor = false;

	        // Asignar vendedores a productos
	        producto1.vendedor = usuario1;
	        producto2.vendedor = usuario2;
	        producto3.vendedor = usuario1;

	        // Crear carrito
	        Carrito carrito1 = new Carrito();
	        carrito1.productos = new Producto[]{producto1, producto2};
	        carrito1.cantidades = new int[]{1, 2};
	        carrito1.descuento = 0;
	        
	        Carrito carrito2 = new Carrito();
	        carrito2.productos = new Producto[]{producto1, producto2, producto3};
	        carrito2.cantidades = new int[]{1, 2, 1};
	        carrito2.descuento = 0;
	        
	        Carrito carrito3 = new Carrito();
	        carrito3.productos = new Producto[]{producto3};
	        carrito3.cantidades = new int[]{5};
	        carrito3.descuento = 0;
	        
	        Carrito carrito4 = new Carrito();
	        carrito4.productos = new Producto[]{producto1,producto3};
	        carrito4.cantidades = new int[]{1,1};
	        carrito4.descuento = 50;

	        Compra compra1U1 = new Compra();
	        compra1U1.fecha = new Date();
	        compra1U1.carrito = carrito1;
	        compra1U1.tipoPago = "Tarjeta";
	        compra1U1.calificacion = 5;

	        Compra compra2U1 = new Compra();
	        compra2U1.fecha = new Date(); 
	        compra2U1.carrito = carrito2; 
	        compra2U1.tipoPago = "Efectivo"; 
	        compra2U1.calificacion = 5;

	        Compra compra1U2 = new Compra();
	        compra1U2.fecha = new Date(); 
	        compra1U2.carrito = carrito3; 
	        compra1U2.tipoPago = "Tarjeta";
	        compra1U2.calificacion = 5;

	        Compra compra1U3 = new Compra();
	        compra1U3.fecha = new Date(); 
	        compra1U3.carrito = carrito4;
	        compra1U3.tipoPago = "Tarjeta";
	        compra1U3.calificacion = 5;


	        // Asignar compra a usuarios
	        usuario1.compras = new Compra[]{compra1U1,compra2U1};
	        usuario2.compras = new Compra[]{compra1U2};
	        usuario3.compras = new Compra[]{compra1U3};

	        // Crear instancia de TiendaOnline
	        TiendaOnline tienda = new TiendaOnline();
	        tienda.usuarios = new Usuario[]{usuario1, usuario2, usuario3};

	        // Probar el método mejorVendedor
	        Usuario mejorVendedor = tienda.mejorVendedor();
	        System.out.println("El mejor vendedor es: " + mejorVendedor);
	}
}


