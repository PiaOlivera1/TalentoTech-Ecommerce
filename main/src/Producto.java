public class Producto {
        private String nombre;
        private int idProducto;

        public Producto(int idProducto, String nombre) {
            this.idProducto = idProducto;
            this.nombre = nombre;
        }

        public int getidProducto(){
            return idProducto;
        }
        public String getNombre() {

            return nombre;
        }

        public void setNombre(String nuevoNombre) {

            this.nombre = nuevoNombre;
        }

        @Override
        public String toString() {

            return nombre;
        }


}
