class CreateComments < ActiveRecord::Migration
  def change
    create_table :comments do |t|
      t.text :content
      t.integer :member_id
      t.integer :book_id
      t.integer :rating

      t.timestamps null: false
    end
  end
end
