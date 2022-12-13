import org.junit.jupiter.api.Test;

import java.util.*;

import org.junit.Assert;

class AppTest {

	@Test
	void testAgregar_libro() {
		
		List<List<String>> libros = App.crear_libros();
		
		List<List<String>> libros_esperados = App.crear_libros();
		List<String> libro = new ArrayList<>();
		
		libro.add ("El principito");
        libro.add ("ANTOINE SAINTEXUPERY");
        libro.add ("1943");
        libro.add ("102");
        libro.add ("SALAMANDRA");
        libro.add ("Plan lector");
        libro.add ("9789563600810");
        libro.add ("3;A1;E;(1,1)");
        libro.add ("Reservado");
        libro.add ("Uno de los primeros libros que uno lee");
        
        libros_esperados.add(libro);
        
		
		Assert.assertEquals(libros_esperados, App.agregar_libro(libros, libro));
	}

	@Test
	void testBuscar_libro_1_filtro() {
		
		List<List<String>> libros = App.crear_libros();
        
        List<String> filtros = new ArrayList<>();
        
        filtros.add("El rubius");
        
        List<List<String>> libros_encontrados = new ArrayList<>();

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
        
        libros_encontrados.add(libro1);
        
		
		Assert.assertEquals(libros_encontrados, App.buscar_libro(libros, filtros));
	}
	
	@Test
	void testBuscar_libro_2_filtro() {
		
		List<List<String>> libros = App.crear_libros();
        
        List<String> filtros = new ArrayList<>();
        
        filtros.add("El rubius");
        filtros.add("El libro troll");
        
        List<List<String>> libros_encontrados = new ArrayList<>();

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
        
        libros_encontrados.add(libro1);
        
		
		Assert.assertEquals(libros_encontrados, App.buscar_libro(libros, filtros));
	}
	
	@Test
	void testBuscar_libro_3_filtro() {
		
		List<List<String>> libros = App.crear_libros();
        
        List<String> filtros = new ArrayList<>();
        
        filtros.add("El rubius");
        filtros.add("El libro troll");
        filtros.add("9788499983196");
        
        List<List<String>> libros_encontrados = new ArrayList<>();

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
        
        libros_encontrados.add(libro1);
        
		
		Assert.assertEquals(libros_encontrados, App.buscar_libro(libros, filtros));
	}

	@Test
	void testEditar_libro() {
		
		List<List<String>> libros = App.crear_libros();
        
        List<List<String>> libros_editado = new ArrayList<>();
        
        List<List<String>> editado = new ArrayList<>();
        

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
        libro2.add ("Otro titulo para la prueba");
        libro2.add ("Alexby11;Mangel;Sr. Cheeto");
        libro2.add ("1999");
        libro2.add ("192");
        libro2.add ("Temas de Hoy");
        libro2.add ("Humor");
        libro2.add ("9788499984629");
        libro2.add ("3;E4;S;(5,13)");
        libro2.add ("Disponible");
        libro2.add ("Los amigos del rubius sacaron un libro");
        
        libros_editado.add(libro1);
        libros_editado.add(libro2);
        
        editado = App.editar_libro(libros, 1, 1, "Otro titulo para la prueba");
        editado = App.editar_libro(libros, 1, 3, "1999");
		
		Assert.assertEquals(libros_editado, editado);
	}

	@Test
	void testBorrar_libro() {
		List<List<String>> libros = App.crear_libros();
        
        List<List<String>> libros_borrado = new ArrayList<>();
        
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
        
        libros_borrado.add(libro2);
        
        Assert.assertEquals(libros_borrado, App.borrar_libro(libros, 0));

	}

}
