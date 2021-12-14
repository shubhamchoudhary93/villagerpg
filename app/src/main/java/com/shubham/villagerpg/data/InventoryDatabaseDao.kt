package com.shubham.villagerpg.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface InventoryDatabaseDao {
    @Insert
    fun insert(inventory: Inventory)

    @Update
    fun update(inventory: Inventory)

    @Query("SELECT * from inventory_data_table WHERE id = :id")
    fun get(id: Long): Inventory?

    @Query("DELETE FROM inventory_data_table WHERE id = :id")
    fun delete(id: Long)

    @Query("DELETE FROM inventory_data_table")
    fun clear()

    @Query("SELECT * from inventory_data_table WHERE type= :type AND quantity>0")
    fun getAvailableByType(type: String): MutableList<Inventory>

    @Query("SELECT * from inventory_data_table WHERE type= :type")
    fun getAvailableItem(type: String): MutableList<Inventory>

    @Query("SELECT corresponding from inventory_data_table WHERE id = :id")
    fun getCorresponding(id: Long): Long

    @Query("SELECT * from inventory_data_table WHERE quantity>0")
    fun getAvailable(): MutableList<Inventory>

    @Query("SELECT * from inventory_data_table WHERE quantity>0 AND type != :type")
    fun getAvailable(type: String): MutableList<Inventory>

    @Query("SELECT * from inventory_data_table WHERE can_buy= 1 AND unlockLevel >= :level")
    fun getAllBuy(level: Int): MutableList<Inventory>

    @Query("SELECT * from inventory_data_table WHERE quantity>0 AND can_sell = 1")
    fun getAllSell(): MutableList<Inventory>
}