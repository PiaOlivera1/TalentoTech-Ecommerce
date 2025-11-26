public class Producto {
        private String nombre;
        private int id;
        private double precio;

        public Producto(int id, String nombre, double precio) {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
        }

    public Producto(int idSiguiente, String nombre) {
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

            return String.format("Id: %d - Articulo: %s - Precio: %.2f",id, nombre, precio);
        }

        public boolean coincideId(int id){
            return this.id ==id;
        }


}
