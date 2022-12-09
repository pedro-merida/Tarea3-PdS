import java.util.*;

public class App {

    static final Scanner option = new Scanner(System.in);

    static List<String> agregar_libro(){
        String datos;
        datos = option.nextLine();
        List<String> libro = new ArrayList<>();
        System.out.println("\nAgregar registro de un libro\n");

        System.out.print("Titulo: ");
        datos = option.nextLine();

        while (datos == ""){
            System.out.println("Este campo no puede estar vacio");
            System.out.print("Titulo: ");
            datos = option.nextLine();
        }

        libro.add(datos);

        System.out.print("Autor (Si tiene mas de un autor, separelo por ;): ");
        datos = option.nextLine();

        while (datos == ""){
            System.out.println("Este campo no puede estar vacio");
            System.out.print("Autor (Si tiene mas de un autor, separelo por ;): ");
            datos = option.nextLine();
        }

        libro.add(datos);

        System.out.print("Fecha de publicación: ");
        datos = option.nextLine();

        while (datos == ""){
            System.out.println("Este campo no puede estar vacio");
            System.out.print("Fecha de publicación: ");
            datos = option.nextLine();
        }

        libro.add(datos);

        System.out.print("Numero de páginas: ");
        datos = option.nextLine();

        while (datos == ""){
            System.out.println("Este campo no puede estar vacio");
            System.out.print("Numero de páginas: ");
            datos = option.nextLine();
        }

        libro.add(datos);

        System.out.print("Editorial: ");
        datos = option.nextLine();

        while (datos == ""){
            System.out.println("Este campo no puede estar vacio");
            System.out.print("Editorial: ");
            datos = option.nextLine();
        }

        libro.add(datos);

        System.out.print("Género: ");
        datos = option.nextLine();

        while (datos == ""){
            System.out.println("Este campo no puede estar vacio");
            System.out.print("Género: ");
            datos = option.nextLine();
        }

        libro.add(datos);

        System.out.print("Código ISBN: ");
        datos = option.nextLine();

        while (datos == ""){
            System.out.println("Este campo no puede estar vacio");
            System.out.print("Código ISBN: ");
            datos = option.nextLine();
        }

        libro.add(datos);

        System.out.print("Ubicación (formato: piso de biblioteca; número de pasillo; estante; (x,y)): ");
        datos = option.nextLine();

        String[] verificacion_datos = datos.split(";");

        while (datos == "" || verificacion_datos.length != 4){
            System.out.println("El formato no es el correcto");
            System.out.print("Ubicación (formato: piso de biblioteca; número de pasillo; estante; (x,y)): ");
            datos = option.nextLine();
            verificacion_datos = datos.split(";");
        }

        libro.add(datos);

        System.out.print("Estado (Disponible, Prestado o Extraviado): ");
        datos = option.nextLine();

        while (!(datos.equals("Disponible") || datos.equals("Prestado") || datos.equals("Extraviado"))){
            System.out.println("Formato incorrecto, favor de utilizar el formato sugerido");
            System.out.print("Estado (Disponible, Prestado o Extraviado): ");
            datos = option.nextLine();
        }

        libro.add(datos);

        System.out.print("Descripción: ");
        datos = option.nextLine();

        while (datos == ""){
            System.out.println("Este campo no puede estar vacio");
            System.out.print("Descripción: ");
            datos = option.nextLine();
        }

        libro.add(datos);
        
        return libro;
    }
    
    static List<List<String>> buscar_libro(List<List<String>> libros){
        List<List<String>> filtrados = new ArrayList<>();
        List<List<String>> filtrados1 = new ArrayList<>();
        List<List<String>> filtrados2 = new ArrayList<>();
        List<String> filtros = new ArrayList<>();
        String titulo = "";
        String autor = "";
        String isbn = "";

        System.out.println("\nBuscar libro\n");
        titulo = option.nextLine();
        System.out.println("Introduzca los datos del libro que quiera buscar (aquellos que no desee ingresar puede dejarlos en blanco)\n");

        System.out.print("Titulo: ");
        titulo = option.nextLine();

        if (!(titulo.equals(""))){
            filtros.add(titulo);
        }

        System.out.print("Autor (Si tiene mas de un autor, separelo por ;): ");
        autor = option.nextLine();

        if (!(autor.equals(""))){
            filtros.add(autor);
        }

        System.out.print("Código ISBN: ");
        isbn = option.nextLine();

        if (!(isbn.equals(""))){
            filtros.add(isbn);
        }

        while (titulo.equals("") && autor.equals("") && isbn.equals("")){
            System.out.println("\nAlguno de los campos debe contener un valor, introduzca los datos del libro que quiera buscar (aquellos que no desee ingresar puede dejarlos en blanco)\n");

            System.out.print("Titulo: ");
            titulo = option.nextLine();

            if (!(titulo.equals(""))){
                filtros.add(titulo);
            }

            System.out.print("Autor (Si tiene mas de un autor, separelo por ;): ");
            autor = option.nextLine();

            if (!(autor.equals(""))){
                filtros.add(autor);
            }

            System.out.print("Código ISBN: ");
            isbn = option.nextLine();

            if (!(isbn.equals(""))){
                filtros.add(isbn);
            }
        }


        int cont_filtro = 0;

        for (int i = 0; i < filtros.size(); i++){
            if (cont_filtro == 0){
                for (int j = 0; j < libros.size(); j++){
                    if (libros.get(j).contains(filtros.get(i))){
                        filtrados1.add(libros.get(j));
                    }
                }
            }
            else if (cont_filtro == 1){
                for (int j = 0; j < filtrados1.size(); j++){
                    if (filtrados1.get(j).contains(filtros.get(i))){
                        filtrados2.add(filtrados1.get(j));
                    }
                }
            }
            else if (cont_filtro == 2){
                for (int j = 0; j < filtrados2.size(); j++){
                    if (filtrados2.get(j).contains(filtros.get(i))){
                        filtrados.add(filtrados2.get(j));
                    }
                }
            }

            cont_filtro++;

        }

        if (cont_filtro == 1){
            return filtrados1;
        }
        else if (cont_filtro == 2){
            return filtrados2;
        }

        return filtrados;
    }
    
    static List<List<String>> editar_libro(List<List<String>> libros){
        int libro;
        int campo = 0;
        String datos;

        System.out.println("\nEditar libro\n");

        for (int i = 0; i < libros.size(); i++){
            System.out.println("["+(i + 1)+"] "+libros.get(i));
        }
        System.out.print("\nSeleccione el libro que quiere editar: ");
        libro = option.nextInt();

        while (libro > libros.size()){
            System.out.print("\nOpcion invalida, porfavor seleccione una opcion dentro de rango: ");
            libro = option.nextInt();
        }


        libro = libro - 1;

        while(campo != 11){
            System.out.println("\nEditando \""+(libros.get(libro)).get(0)+"\"\n");

            System.out.println("[1] Titulo");
            System.out.println("[2] Autor");
            System.out.println("[3] Año de publicacion");
            System.out.println("[4] Numero de paginas");
            System.out.println("[5] Editorial");
            System.out.println("[6] Genero");
            System.out.println("[7] Codigo ISBN");
            System.out.println("[8] Ubicacion");
            System.out.println("[9] Estado");
            System.out.println("[10] Descripcion");
            System.out.println("[11] Salir");
            System.out.println("");

            System.out.print("\nSeleccione el campo que quiere editar: ");
            campo = option.nextInt();

            if (campo == 1){
                datos = option.nextLine();
                System.out.print("Titulo: ");
                datos = option.nextLine();

                while (datos == ""){
                    System.out.println("Este campo no puede estar vacio");
                    System.out.print("Titulo: ");
                    datos = option.nextLine();
                }
                (libros.get(libro)).set((campo-1), datos);
            }
            else if (campo == 2){
                datos = option.nextLine();
                System.out.print("Autor (Si tiene mas de un autor, separelo por ;): ");
                datos = option.nextLine();

                while (datos == ""){
                    System.out.println("Este campo no puede estar vacio");
                    System.out.print("Autor (Si tiene mas de un autor, separelo por ;): ");
                    datos = option.nextLine();
                }
                (libros.get(libro)).set((campo-1), datos);
            }
            else if (campo == 3){
                datos = option.nextLine();
                System.out.print("Año de publicacion: ");
                datos = option.nextLine();

                while (datos == ""){
                    System.out.println("Este campo no puede estar vacio");
                    System.out.print("Año de publicacion: ");
                    datos = option.nextLine();
                }
                (libros.get(libro)).set((campo-1), datos);
            }
            else if (campo == 4){
                datos = option.nextLine();
                System.out.print("Numero de paginas: ");
                datos = option.nextLine();

                while (datos == ""){
                    System.out.println("Este campo no puede estar vacio");
                    System.out.print("Numero de paginas: ");
                    datos = option.nextLine();
                }
                (libros.get(libro)).set((campo-1), datos);
            }
            else if (campo == 5){
                datos = option.nextLine();
                System.out.print("Editorial: ");
                datos = option.nextLine();

                while (datos == ""){
                    System.out.println("Este campo no puede estar vacio");
                    System.out.print("Editorial: ");
                    datos = option.nextLine();
                }
                (libros.get(libro)).set((campo-1), datos);
            }
            else if (campo == 6){
                datos = option.nextLine();
                System.out.print("Genero: ");
                datos = option.nextLine();

                while (datos == ""){
                    System.out.println("Este campo no puede estar vacio");
                    System.out.print("Genero: ");
                    datos = option.nextLine();
                }
                (libros.get(libro)).set((campo-1), datos);
            }
            else if (campo == 7){
                datos = option.nextLine();
                System.out.print("Codigo ISBN: ");
                datos = option.nextLine();

                while (datos == ""){
                    System.out.println("Este campo no puede estar vacio");
                    System.out.print("Codigo ISBN: ");
                    datos = option.nextLine();
                }
                (libros.get(libro)).set((campo-1), datos);
            }
            else if (campo == 8){
                datos = option.nextLine();
                System.out.print("Ubicación (formato: piso de biblioteca; número de pasillo; estante; (x,y)): ");
                datos = option.nextLine();

                String[] verificacion_datos = datos.split(";");

                while (datos == "" || verificacion_datos.length != 4){
                    System.out.println("El formato no es el correcto");
                    System.out.print("Ubicación (formato: piso de biblioteca; número de pasillo; estante; (x,y)): ");
                    datos = option.nextLine();
                    verificacion_datos = datos.split(";");
                }
                (libros.get(libro)).set((campo-1), datos);
            }
            else if (campo == 9){
                datos = option.nextLine();
                System.out.print("Estado (Disponible, Prestado o Extraviado): ");
                datos = option.nextLine();

                while (!(datos.equals("Disponible") || datos.equals("Prestado") || datos.equals("Extraviado"))){
                    System.out.println("Formato incorrecto, favor de utilizar el formato sugerido");
                    System.out.print("Estado (Disponible, Prestado o Extraviado): ");
                    datos = option.nextLine();
                }
                (libros.get(libro)).set((campo-1), datos);
            }
            else if (campo == 10){
                datos = option.nextLine();
                System.out.print("Descripcion: ");
                datos = option.nextLine();

                while (datos == ""){
                    System.out.println("Este campo no puede estar vacio");
                    System.out.print("Descripcion: ");
                    datos = option.nextLine();
                }
                (libros.get(libro)).set((campo-1), datos);
            }
        }

        return libros;
    }
    
    static List<List<String>> borrar_libro(List<List<String>> libros){
        int libro;

        System.out.println("\nBorrar registro de un libro\n");

        for (int i = 0; i < libros.size(); i++){
            System.out.println("["+(i + 1)+"] "+libros.get(i));
        }
        System.out.print("\nSeleccione el libro que quiere borrar: ");
        libro = option.nextInt();

        while (libro > libros.size()){
            System.out.print("\nOpcion invalida, porfavor seleccione una opcion dentro de rango: ");
            libro = option.nextInt();
        }

        libro = libro - 1;

        libros.remove(libro);

        return libros;
    }
    public static void main(String[] args) throws Exception {

        List<List<String>> libros = new ArrayList<>();

        List<String> libro1 = new ArrayList<>();
        libro1.add ("El libro troll");
        libro1.add ("El rubius");
        libro1.add ("2014");
        libro1.add ("192");
        libro1.add ("Temas de Hoy");
        libro1.add ("Humor");
        libro1.add ("9788499983196");
        libro1.add ("2;A4;E;(2,3)");
        libro1.add ("Disponible");
        libro1.add ("El libro del rubius");

        List<String> libro2 = new ArrayList<>();
        libro2.add ("Salseo Gamer");
        libro2.add ("Alexby11;Mangel;Sr. Cheeto");
        libro2.add ("2015");
        libro2.add ("192");
        libro2.add ("Temas de Hoy");
        libro2.add ("Humor");
        libro2.add ("9788499984629");
        libro2.add ("3;E4;S;(5,13)");
        libro2.add ("Disponible");
        libro2.add ("Los amigos del rubius sacaron un libro");

        libros.add(libro1);
        libros.add(libro2);


        int opcion = 0;

        while (opcion != 5){
            System.out.println("\nBienvenido al gestor de libros de biblioteca");
            System.out.println("");

            System.out.println("[1] Registrar libro");
            System.out.println("[2] Buscar libro");
            System.out.println("[3] Editar libro");
            System.out.println("[4] Eliminar registro de libro");
            System.out.println("[5] Salir");
            System.out.println("");
            
        
            System.out.print("Ingrese la opción que quiere realizar: ");
            opcion = option.nextInt();
            if (opcion == 1){
                List<String> libro_agregado = agregar_libro();
                libros.add(libro_agregado);
                System.out.println("\nLibro registrado existosamente\n");
            }
            else if (opcion == 2){
                List<List<String>> libros_buscados = buscar_libro(libros);
                if (libros_buscados.isEmpty()){
                    System.out.println("\nNo se encontraron libros con los datos que entrego");
                }
                else{
                    System.out.println("\nLibros encontrados: \n");
                    for (int i = 0; i < libros_buscados.size(); i++){
                        System.out.println(libros_buscados.get(i));
                    }
                }
            }
            else if (opcion == 3){
                List<List<String>> libros_editados = editar_libro(libros);
                libros = new ArrayList<>(libros_editados);
                System.out.println("\nLibro editado exitosamente\n");
            }
            else if (opcion == 4){
                if (libros.size() == 0){
                    System.out.println("\nNo hay libros que eliminar\n");
                }
                else{
                    List<List<String>> libros_borrados = borrar_libro(libros);
                libros = new ArrayList<>(libros_borrados);
                System.out.println("\nLibro eliminado exitosamente\n");
                }
            }
        }
    }
}
