package net.dandielo.citizens.traders_v3.utils.items.data;

import org.bukkit.inventory.ItemStack;

import net.dandielo.citizens.traders_v3.core.exceptions.InvalidDataAssignmentException;
import net.dandielo.citizens.traders_v3.core.exceptions.ItemDataNotFoundException;
import net.dandielo.citizens.traders_v3.traders.stock.StockItem;
import net.dandielo.citizens.traders_v3.utils.items.DataNode;
import net.dandielo.citizens.traders_v3.utils.items.ItemData;

@DataNode(name="Slot", saveKey="s")
public class Slot extends ItemData {

	private int slot;
	
	public Slot(String key) {
		super(key);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getValue(StockItem stockItem) {
		return (T) new Integer(slot);
	}
	
	public Slot setSlot(int slot)
	{
		this.slot = slot;
		return this;
	}
	
	public int getSlot()
	{
		return slot;
	}

	@Override
	public void assing(ItemStack item) {
	}

	@Override
	public void checkItemCompatibility(ItemStack item)
			throws InvalidDataAssignmentException {
	}

	@Override
	public void load(String value) {
		slot = Integer.parseInt(value);
	}

	@Override
	public String save() {
		return String.valueOf(slot);
	}

	@Override
	public void peek(ItemStack item) throws ItemDataNotFoundException {
		//nothing to do here
		slot = -1;
	}
	
	//equality check
	public boolean equals(Slot slot)
	{
		return slot.slot == this.slot;
	}
	
	@Override
	public boolean equals(Object o)
	{
		return o instanceof Slot ? equals((Slot)o) : false;
	}
	
}
