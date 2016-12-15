class Cart < ActiveRecord::Base
    has_many :lineitems, :dependent => :destroy
    
    def add_book(book_id)
        current_item = lineitems.find_by_book_id(book_id)
        if current_item
            current_item.quantity +=1
        else
            current_item = lineitems.new(book_id: book_id)
            current_item.quantity =1
        end
        current_item
    end
end
