class Lineitem < ActiveRecord::Base
    belongs_to :cart
    belongs_to :book
    belongs_to :order
end
