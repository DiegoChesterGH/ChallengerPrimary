package ar.com.primary.challenge.secuencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SequenceIterator 
{
	//La creo aca para no armar mas archivos (la uso de estructura sin encapsulamento)
	public class Tabla
	{
		public Iterator<Comparable<Object>> lst;
		public Comparable<Object> valor;

		public Tabla( Iterator<Comparable<Object>> lst, Comparable<Object> valor)
		{
			this.valor = valor;
			this.lst = lst;
		}

	}
	private	ArrayList <Tabla> listCoparable = new ArrayList<Tabla>();

	public SequenceIterator(Collection<Iterator<Comparable<Object>>> inputs) 
	{
		//ArmoLista por primera vez
		for ( Iterator<Comparable<Object>> lista : inputs) 
			if( lista.hasNext() ) // Cargo los primeros valores
				listCoparable.add( new Tabla( lista, lista.next()));
	}
	public boolean hasNext() 
	{
		if (listCoparable.size() > 0 ) //siempre cargo mi lista
			return true;

		return false;
	}
	public Comparable<Object> next() 
	{
		Tabla min =null;
		for (Tabla item : listCoparable) 
		{
			if (min==null || min.valor.compareTo(item)>0   )
				min=item;
		}
		//Cargo el valor obtenido
		if( min.lst.hasNext() )
			min.valor =  min.lst.next();
		else //si no hay valor posterior lo eliminamos de la lista
			listCoparable.remove(min);

		return min.valor;

	}

}


