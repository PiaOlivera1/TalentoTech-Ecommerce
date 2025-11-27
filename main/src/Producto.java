public class Producto {
        private String nombre;
        private int id;
        private double precio;

        private static int nextId =1; // solo se puede acceder desder la clase producto
        // SIEMPRE ESTATICO!!!!

        public Producto(String nombre, double precio) {
           this(nombre);
           this.precio = precio;
        }

    public Producto(String nombre) {
            this.id = nextId;
            nextId++;
            this.nombre = nombre;
    }




    public int getidProducto(){
            return this.id;
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
            this.precio =nuevoPrecio;
        }

        @Override
        public String toString() {

            return String.format("Id: %d - Articulo: %s - Precio: %.2f",this.id, this.nombre, this.precio);
        }

        public boolean coincideId(int idBuscado){
            return this.id == idBuscado;
        }


}
