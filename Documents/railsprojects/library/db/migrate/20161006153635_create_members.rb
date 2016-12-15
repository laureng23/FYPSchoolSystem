class CreateMembers < ActiveRecord::Migration
  def change
    create_table :members do |t|
      t.string :name
      t.string :address
      t.string :email
      t.string :phone
      t.string :password_digest

      t.timestamps null: false
    end
  end
end
