public class Producto {
        private String nombre;

        public Producto(String nombre) {
            this.nombre = nombre;
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
