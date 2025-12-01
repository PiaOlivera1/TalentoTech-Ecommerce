public class Producto {
        private String nombre;
        private int id;
        private double precio;
        private int stock;
        private boolean tieneDescuento;
        private int cantidad;
        private String descripcion;
        String categoria;

        private static int nextId =1; // solo se puede acceder desder la clase producto
        // SIEMPRE ESTATICO!!!!

        public Producto(String nombre, double precio, String descripcion, String categoria) {
           this.id = Producto.nextId;
           Producto.nextId++;
           this.nombre = nombre;
           this.precio = precio;
           this.descripcion = descripcion;
           this.categoria = categoria;

        }

//    public Producto(String nombre) {
//            this.id = nextId;
//            nextId++;
//            this.nombre = nombre;
//    }




    public int getidProducto(){
            return this.id;
        }

    public int getId() {
        return id;
    }

    public boolean isTieneDescuento() {
        return this.tieneDescuento;
    }

    public void setTieneDescuento(boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }

    public  String getNombre() {

            return this.nombre;
        }

        public void setNombre(String nuevoNombre) {

            this.nombre = nuevoNombre;
        }
        public double getPrecio(){
            return this.precio;
        }
        public void setPrecio(double nuevoPrecio){
            if (precio <= 0){
                System.out.println("El precio debe ser mayor a cero, no se modifico nada");
                return;
            }
            this.precio =nuevoPrecio;
        }

        public void updateStock(int stockAQuitar) {
        this.stock = stock -stockAQuitar;
        }

        public String getDescipcion(){ return descripcion; }

    
    @Override
        public String toString() {

            return String.format("Id: %d - Articulo: %s - Precio: %.2f",this.id, this.nombre, this.precio);
        }

        public boolean coincideId(int idBuscado){
            return this.id == idBuscado;
        }


}
