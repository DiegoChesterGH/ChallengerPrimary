package ar.com.primary.challenge.concurrencia;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import ar.com.primary.challenge.swing.VentanaSwing;

public class ImplConcurrentMemoryStore implements ConcurrentMemoryStore
{

	ConcurrentHashMap<String, Item> miLista = new ConcurrentHashMap<String, Item>();
	
	@Override
	public void remove(String key) {
		
		synchronized (this) {
			if(miLista.containsKey(key))
				miLista.remove(key);
		}

	}

	@Override
	public void store(String key, Item item) throws IllegalArgumentException {

	
			if(miLista.containsKey(key))
				new IllegalArgumentException("Clave existente");
			
			miLista.put(key, item);
		
	}

	@Override
	public void update(String key, int value1, int value2) {
		
			if(miLista.containsKey(key))
			{
				Item it = miLista.get(key);
				it.setValue1(value1);
				it.setValue2(value2);
			}
	}

	@Override
	public Iterator<Item> valueIterator() 
	{
		return  miLista.values().iterator();
	}
}



