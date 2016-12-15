class AddCartToBooks < ActiveRecord::Migration
  def change
    add_column :books, :cart_id, :integer
  end
end
