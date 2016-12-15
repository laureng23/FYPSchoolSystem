class CreateFrees < ActiveRecord::Migration
  def change
    create_table :frees do |t|
      t.string :title
      t.string :attachment

      t.timestamps null: false
    end
  end
end
