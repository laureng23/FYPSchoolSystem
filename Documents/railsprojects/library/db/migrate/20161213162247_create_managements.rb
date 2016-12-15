class CreateManagements < ActiveRecord::Migration
  def change
    create_table :managements do |t|
      t.string :username
      t.string :password_digest

      t.timestamps null: false
    end
  end
end
