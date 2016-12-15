class CreateReservations < ActiveRecord::Migration
  def change
    create_table :reservations do |t|
      t.date :pick_up_date
      t.integer :book_id
      t.integer :member_id

      t.timestamps null: false
    end
  end
end
