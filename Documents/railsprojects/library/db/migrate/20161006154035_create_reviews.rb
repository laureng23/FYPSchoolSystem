class CreateReviews < ActiveRecord::Migration
  def change
    create_table :reviews do |t|
      t.integer :rating
      t.string :descritpion
      t.boolean :recommend
      t.integer :member_id
      t.integer :book_id

      t.timestamps null: false
    end
  end
end
