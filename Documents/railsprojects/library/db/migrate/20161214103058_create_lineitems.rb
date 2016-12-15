class CreateLineitems < ActiveRecord::Migration
  def change
    create_table :lineitems do |t|
      t.integer :book_id
      t.integer :order_id
      t.integer :quantity
      t.integer :cart_id

      t.timestamps null: false
    end
  end
end
